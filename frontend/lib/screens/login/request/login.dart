import 'dart:async';
import 'dart:convert';
import 'package:dio/dio.dart';
import 'package:outlook/common/configuration/dio_config.dart';
import 'package:outlook/models/User.dart';

Future<User> login(String email, String senha) async {
  final response = await createDio().post("/authenticate",
      data: jsonEncode({'email': email, "senha": senha}),
      options: Options(headers: {"requiresToken": false}));

  if (response.statusCode == 200) {
    return User.fromJson(response.data);
  } else {
    throw Exception('Erro ao tentar logar');
  }
}
