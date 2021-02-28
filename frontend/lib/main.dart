import 'package:flutter/material.dart';
import 'package:outlook/screens/login/login_screen.dart';
import 'package:outlook/screens/main/main_screen.dart';
import 'package:outlook/screens/signup/signup_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Tormenta 20',
      theme: ThemeData(),
      initialRoute: '/',
      routes: {
        "/": (context) => LoginScreen(),
        "/main": (context) => MainScreen(),
        "/create": (context) => SignupScreen()
      },
    );
  }
}
