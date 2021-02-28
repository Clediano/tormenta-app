import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:outlook/common/constants.dart';
import 'package:outlook/common/shared_key.dart';
import 'package:outlook/screens/login/request/login.dart';
import 'package:shared_preferences/shared_preferences.dart';

class LoginScreen extends StatelessWidget {
  final TextEditingController _usernameController = new TextEditingController();
  final TextEditingController _passwordController = new TextEditingController();

  void _login(context) async {
    await login(
      _usernameController.text,
      _passwordController.text,
    ).then(
      (value) async {
        SharedPreferences prefs = await SharedPreferences.getInstance();
        await prefs.setString(SharedKey.USERNAME.toShortString(), value.nome);
        await prefs.setString(SharedKey.EMAIL.toShortString(), value.email);
        await prefs.setString(SharedKey.AUTH_TOKEN.toShortString(), value.token);
        await prefs.setString(SharedKey.PEOPLE_ID.toShortString(), value.id);
        Navigator.pushNamed(context, "/main");
      },
    ).catchError(
      (onError) => {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Usuário ou senha inválido'),
            backgroundColor: kErrorColor,
          ),
        ),
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity,
        height: double.infinity,
        decoration: BoxDecoration(
          image: const DecorationImage(
            image: AssetImage("assets/images/background-login.jpg"),
            fit: BoxFit.cover,
          ),
        ),
        child: BackdropFilter(
          filter: new ImageFilter.blur(sigmaX: 5.0, sigmaY: 5.0),
          child: Center(
            child: Container(
              height: 450,
              width: 320,
              padding: const EdgeInsets.all(kDefaultPadding * 0.75),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    children: [
                      SizedBox(height: kDefaultPadding),
                      Image.asset("assets/images/logo-tormenta-preto.png"),
                      SizedBox(height: kDefaultPadding * 0.50),
                      Text(
                        "Welcome chamption",
                        textAlign: TextAlign.center,
                        style: TextStyle(color: kTextColor),
                      ),
                    ],
                  ),
                  Container(
                    child: Column(
                      children: [
                        TextField(
                          controller: _usernameController,
                          onChanged: (value) {},
                          autofocus: true,
                          decoration: InputDecoration(
                            hintText: "E-mail",
                            fillColor: kBgDarkColor,
                            filled: true,
                            prefixIcon: Padding(
                              padding: const EdgeInsets.all(
                                  kDefaultPadding * 0.75), //15
                              child: Icon(Icons.person),
                            ),
                            border: OutlineInputBorder(
                              borderRadius: BorderRadius.all(
                                Radius.circular(10),
                              ),
                              borderSide: BorderSide.none,
                            ),
                          ),
                        ),
                        SizedBox(height: kDefaultPadding),
                        TextField(
                          controller: _passwordController,
                          obscureText: true,
                          enableSuggestions: false,
                          autocorrect: false,
                          onChanged: (value) {},
                          decoration: InputDecoration(
                            hintText: "Password",
                            fillColor: kBgDarkColor,
                            filled: true,
                            prefixIcon: Padding(
                              padding: const EdgeInsets.all(
                                  kDefaultPadding * 0.75), //15
                              child: Icon(Icons.vpn_key),
                            ),
                            border: OutlineInputBorder(
                              borderRadius:
                                  BorderRadius.all(Radius.circular(10)),
                              borderSide: BorderSide.none,
                            ),
                          ),
                        ),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.end,
                          children: [
                            TextButton(
                              onPressed: () =>
                                  Navigator.pushNamed(context, "/create"),
                              child: Text(
                                "Create new account?",
                                textAlign: TextAlign.right,
                                style: Theme.of(context)
                                    .textTheme
                                    .button
                                    .copyWith(color: kPrimaryColor),
                              ),
                              style: TextButton.styleFrom(
                                padding: EdgeInsets.symmetric(
                                    horizontal: kDefaultPadding),
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(20),
                                ),
                              ),
                            ),
                          ],
                        )
                      ],
                    ),
                  ),
                  TextButton.icon(
                    onPressed: () {
                      _login(context);
                    },
                    style: TextButton.styleFrom(
                      minimumSize: Size(300, 50),
                      primary: kTextColor,
                      padding: EdgeInsets.symmetric(vertical: kDefaultPadding),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      backgroundColor: kPrimaryColor,
                    ),
                    icon: Icon(
                      Icons.login,
                      color: kSecondaryColor,
                    ),
                    label: Text(
                      "LOGIN",
                      style: TextStyle(color: kSecondaryColor),
                    ),
                  ),
                ],
              ),
              decoration: BoxDecoration(
                color: kBgLightColor,
                borderRadius: BorderRadius.circular(15),
                boxShadow: [
                  BoxShadow(
                    offset: const Offset(5, 5),
                    blurRadius: 15,
                    color: const Color(0x26234395),
                  ),
                  BoxShadow(
                    offset: const Offset(5, 5),
                    blurRadius: 15,
                    color: Colors.white60,
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
