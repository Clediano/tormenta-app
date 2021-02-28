import 'package:flutter/material.dart';
import 'package:outlook/models/Character.dart';
import 'package:outlook/models/Email.dart';
import 'package:outlook/common/responsive.dart';
import 'package:outlook/screens/email/email_screen.dart';
import 'package:outlook/screens/main/request/load_character.dart';
import '../../../common/constants.dart';
import 'email_card.dart';
import 'package:flutter/foundation.dart' show kIsWeb;

class ListOfCharacters extends StatefulWidget {
  const ListOfCharacters({
    Key key,
    this.personName = "Nome do jogador",
  }) : super(key: key);

  final String personName;

  @override
  _ListOfCharactersState createState() => _ListOfCharactersState();
}

class _ListOfCharactersState extends State<ListOfCharacters> {
  final Character _character = null;

  @override
  void initState() {
    super.initState();
    _load_character();
  }

  void _load_character() async {
    await loadCharacter().then((value) => setState(() => {_character: value}));
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(top: kIsWeb ? kDefaultPadding : 0),
      color: kBgDarkColor,
      child: SafeArea(
        right: false,
        child: Column(
          children: [
            // This is our Seearch bar
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
              child: Row(
                children: [
                  Expanded(
                    child: Image.asset("assets/images/logo-tormenta-preto.png"),
                  ),
                ],
              ),
            ),
            SizedBox(height: kDefaultPadding),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Tooltip(
                    message: widget.personName,
                    child: Text(
                      _character != null ? _character.nome : "",
                      style: Theme.of(context).textTheme.bodyText1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: kDefaultPadding),
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
