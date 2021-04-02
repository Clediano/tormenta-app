import 'package:flutter/material.dart';
import 'package:outlook/common/responsive.dart';
import 'package:outlook/models/Character.dart';
import 'package:outlook/models/Email.dart';
import 'package:outlook/screens/email/email_screen.dart';
import 'package:outlook/screens/main/request/load_character.dart';

import '../../../common/constants.dart';
import 'email_card.dart';

class ListOfCharacters extends StatefulWidget {
  const ListOfCharacters({
    Key? key,
    this.personName = "Nome do jogador",
  }) : super(key: key);

  final String personName;

  @override
  _ListOfCharactersState createState() => _ListOfCharactersState();
}

class _ListOfCharactersState extends State<ListOfCharacters> {
  final Character? _character = null;

  @override
  void initState() {
    super.initState();
    _load_character();
  }

  void _load_character() {
    loadCharacter().then((value) => setState(() => {_character: value}));
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: kBgDarkColor,
      child: SafeArea(
        right: false,
        child: Column(
          children: [
            Expanded(
              child: ListView.builder(
                itemCount: emails.length,
                // On mobile this active dosen't mean anything
                itemBuilder: (context, index) => EmailCard(
                  isActive: Responsive.isMobile(context) ? false : index == 0,
                  email: emails[index],
                  press: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => EmailScreen(email: emails[index]),
                      ),
                    );
                  },
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
