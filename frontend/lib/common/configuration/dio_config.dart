import 'package:dio/dio.dart';
import 'package:outlook/common/constants.dart';
import 'package:outlook/common/shared_key.dart';
import 'package:shared_preferences/shared_preferences.dart';

Dio createDio() {
  return Dio(
    BaseOptions(
      connectTimeout: 5000,
      receiveTimeout: 5000,
      baseUrl: kBaseUrl,
    ),
  );
}

Dio addInterceptors(Dio dio) {
  return dio
    ..interceptors.add(InterceptorsWrapper(
      onRequest: (RequestOptions options) => requestInterceptor(options),
      onResponse: (Response response) => responseInterceptor(response),
    ));
}

dynamic requestInterceptor(RequestOptions options) async {
  if (options.headers.containsKey("requiresToken")) {
    options.headers.remove("requiresToken");

    SharedPreferences prefs = await SharedPreferences.getInstance();
    var token = prefs.get(SharedKey.AUTH_TOKEN.toShortString());

    options.headers.addAll({"Bearer": "$token"});

    return options;
  }
}

dynamic responseInterceptor(Response options) async {
  if (options.headers.value("Authorization") != null) {
    //if the header is present, then compare it with the Shared Prefs key
    SharedPreferences prefs = await SharedPreferences.getInstance();
    var verifyToken =
        prefs.get("Bearer " + SharedKey.AUTH_TOKEN.toShortString());

    // if the value is the same as the header, continue with the request
    if (options.headers.value("Authorization") == verifyToken) {
      return options;
    }
  }

  return DioError(request: options.request, error: "Usuário não autorizado.");
}
