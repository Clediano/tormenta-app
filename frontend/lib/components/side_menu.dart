import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:outlook/common/responsive.dart';
import '../common/constants.dart';

import 'package:flutter/foundation.dart' show kIsWeb;

class SideMenu extends StatelessWidget {
  const SideMenu({
    Key? key,
    this.personName = "Nome do jogador",
  }) : super(key: key);

  final String personName;

  @override
  Widget build(BuildContext context) {
    return Container(
      height: double.infinity,
      padding: EdgeInsets.only(top: kIsWeb ? kDefaultPadding : 0),
      color: kBgLightColor,
      child: SafeArea(
        child: SingleChildScrollView(
          padding: EdgeInsets.symmetric(horizontal: kDefaultPadding),
          child: Column(
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Image.asset(
                    "assets/images/logo-tormenta-preto.png",
                    width: 160,
                  ),
                  if (!Responsive.isDesktop(context)) Spacer(),
                  // We don't want to show this close button on Desktop mood
                  if (!Responsive.isDesktop(context)) CloseButton(),
                ],
              ),
              SizedBox(height: kDefaultPadding),
              Tooltip(
                message: this.personName,
                child: Text(
                  this.personName,
                  style: Theme.of(context).textTheme.bodyText1,
                  overflow: TextOverflow.ellipsis,
                ),
              ),
              SizedBox(height: kDefaultPadding * 2),
              // Menu Items

              Padding(
                padding: const EdgeInsets.only(top: kDefaultPadding),
                child: InkWell(
                  onTap: () {},
                  child: Row(
                    children: [
                      (true)
                          ? SvgPicture.asset(
                              "assets/Icons/Angle right.svg",
                              width: 15,
                            )
                          : SizedBox(width: 15),
                      SizedBox(width: kDefaultPadding / 4),
                    ],
                  ),
                ),
              ),

              SizedBox(height: kDefaultPadding * 2),
              // Tags
            ],
          ),
        ),
      ),
    );
  }
}
