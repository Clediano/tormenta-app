import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:outlook/common/configuration/dio_config.dart';
import 'package:outlook/models/People.dart';

void create(String nome, String email, String senha, Function onSuccess,
    Function onError) {
  createDio()
      .post("/pessoas",
          data: jsonEncode({'nome': nome, 'email': email, "senha": senha}),
          options: Options(
            headers: {"requiresToken": false},
          ))
      .then((response) => onSuccess(People.fromJson(response.data)))
      .catchError((error) => onError(error.response));
}
