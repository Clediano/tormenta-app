import 'package:flutter/material.dart';
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
    String token = prefs.getString(SharedKey.AUTH_TOKEN.toShortString());

    if (token == null) {
      await prefs.clear();
      Navigator.pushNamed(context, "/");
    }
  }

  @override
  Widget build(BuildContext context) {
    Size _size = MediaQuery.of(context).size;

    return Scaffold(
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
