import 'package:flutter/material.dart';
import 'package:outlook/common/constants.dart';
import 'package:outlook/common/responsive.dart';
import 'package:outlook/common/shared_key.dart';
import 'package:outlook/screens/email/email_screen.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'components/list_of_characters.dart';

class MainScreen extends StatefulWidget {
  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  @override
  void initState() {
    super.initState();

    _verifyLogin();
  }

  _verifyLogin() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    String? token = prefs.getString(SharedKey.AUTH_TOKEN.toShortString());

    if (token == null) {
      _logount();
    }
  }

  _logount() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    await prefs.clear();
    Navigator.pushNamed(context, "/");
  }

  _showAlertDialog(BuildContext ctx, Function onConfirm, Function onCancel) {
    AlertDialog alerta = AlertDialog(
      title: Text("Confirmation"),
      content: Text("Are you sure you want to quit?"),
      actions: [
        TextButton(
          style: TextButton.styleFrom(
            backgroundColor: kPrimaryColor,
            padding: EdgeInsets.symmetric(
              horizontal: kDefaultPadding * 0.8,
              vertical: kDefaultPadding * 0.5,
            ),
          ),
          onPressed: onConfirm as void Function()?,
          child: Text(
            "Confirm",
            style: TextStyle(color: kSecondaryColor),
          ),
        ),
        TextButton(
          onPressed: onCancel as void Function()?,
          child: Text(
            "Cancel",
            style: TextStyle(color: kPrimaryColor),
          ),
        ),
      ],
    );
    showDialog(
      context: ctx,
      builder: (BuildContext ctx) {
        return alerta;
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    Size _size = MediaQuery.of(context).size;
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: Image.asset(
          "assets/images/logo-tormenta-preto.png",
          height: 25,
          color: kSecondaryColor,
        ),
        backgroundColor: kPrimaryColor,
        actions: [
          IconButton(
            icon: Icon(Icons.logout),
            onPressed: () {
              _showAlertDialog(
                context,
                _logount,
                () => Navigator.of(context).pop(),
              );
            },
            padding: EdgeInsets.symmetric(horizontal: kDefaultPadding * 0.75),
          ),
        ],
      ),
      body: Responsive(
        mobile: ListOfCharacters(),
        tablet: Row(
          children: [
            Expanded(
              flex: 6,
              child: ListOfCharacters(),
            ),
            Expanded(
              flex: 9,
              child: EmailScreen(),
            ),
          ],
        ),
        desktop: Row(
          children: [
            Expanded(
              flex: _size.width > 1340 ? 2 : 5,
              child: ListOfCharacters(),
            ),
            Expanded(
              flex: _size.width > 1340 ? 8 : 10,
              child: EmailScreen(),
            ),
          ],
        ),
      ),
    );
  }
}
