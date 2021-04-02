import 'dart:convert';
import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:outlook/common/constants.dart';
import 'package:outlook/screens/signup/request/create.dart';

class SignupScreen extends StatefulWidget {
  @override
  _SignupScreenState createState() => _SignupScreenState();
}

class _SignupScreenState extends State<SignupScreen> {
  final TextEditingController _usernameController = new TextEditingController();

  final TextEditingController _emailController = new TextEditingController();

  final TextEditingController _passwordController = new TextEditingController();

  final TextEditingController _repeatPasswordController =
      new TextEditingController();

  final _formKey = GlobalKey<FormState>();

  _createAccount(context) {
    create(
      _usernameController.text,
      _emailController.text,
      _passwordController.text,
      (value) => Navigator.pushNamed(context, "/"),
      (error) {
        print(error);
        Map<String, dynamic>? err = jsonDecode(error.toString());
        _showMessageValidation(
          context: context,
          message: err != null ? err['message'] : "Failed to create your account. Try again in a few minutes.",
        );
      },
    );
  }

  _showMessageValidation(
      {required BuildContext context, required String message, Color bgColor = kErrorColor}) {
    final scaffold = ScaffoldMessenger.of(context);
    scaffold.showSnackBar(
      SnackBar(
        content: Text(message),
        backgroundColor: bgColor,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Form(
        key: _formKey,
        child: Container(
          width: double.infinity,
          height: double.infinity,
          decoration: BoxDecoration(
            image: const DecorationImage(
              image: AssetImage("assets/images/logo-tormenta-signup.jpeg"),
              fit: BoxFit.cover,
            ),
          ),
          child: BackdropFilter(
            filter: new ImageFilter.blur(sigmaX: 5.0, sigmaY: 5.0),
            child: Center(
              child: SingleChildScrollView(
                child: Container(
                  height: 600,
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
                            "Create your account now!",
                            textAlign: TextAlign.center,
                            style: TextStyle(color: kTextColor),
                          ),
                        ],
                      ),
                      Container(
                        child: Column(
                          children: [
                            TextFormField(
                              validator: (value) {
                                if (value!.isEmpty) {
                                  return 'This field is required';
                                }
                                return null;
                              },
                              controller: _usernameController,
                              onChanged: (value) {},
                              autofocus: true,
                              decoration: InputDecoration(
                                hintText: "Username",
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
                            TextFormField(
                              validator: (value) {
                                if (value!.isEmpty) {
                                  return 'This field is required';
                                }
                                if (!RegExp(
                                        r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+")
                                    .hasMatch(value)) {
                                  return 'Enter a valid e-mail';
                                }
                                return null;
                              },
                              controller: _emailController,
                              onChanged: (value) {},
                              autofocus: true,
                              keyboardType: TextInputType.emailAddress,
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
                            TextFormField(
                              validator: (value) {
                                if (value!.isEmpty) {
                                  return 'This field is required';
                                }
                                if (value.length < 8) {
                                  return 'Enter a password with more caracteres';
                                }
                                return null;
                              },
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
                            SizedBox(height: kDefaultPadding),
                            TextFormField(
                              validator: (value) {
                                if (value!.isEmpty) {
                                  return 'This field is required';
                                }
                                if (value != _passwordController.text) {
                                  return 'Passwords is not equals';
                                }
                                return null;
                              },
                              controller: _repeatPasswordController,
                              obscureText: true,
                              enableSuggestions: false,
                              autocorrect: false,
                              onChanged: (value) {},
                              decoration: InputDecoration(
                                hintText: "Repeat your password",
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
                                  onPressed: () {
                                    Navigator.pushNamed(context, "/");
                                  },
                                  child: Text(
                                    "Already have account?",
                                    textAlign: TextAlign.right,
                                    style: Theme.of(context)
                                        .textTheme
                                        .button!
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
                          if (_formKey.currentState!.validate()) {
                            _createAccount(context);
                          }
                        },
                        style: TextButton.styleFrom(
                          minimumSize: Size(300, 50),
                          primary: kTextColor,
                          padding:
                              EdgeInsets.symmetric(vertical: kDefaultPadding),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                          backgroundColor: kPrimaryColor,
                        ),
                        icon: Icon(
                          Icons.send,
                          color: kSecondaryColor,
                        ),
                        label: Text(
                          "SUBMIT",
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
        ),
      ),
    );
  }
}
