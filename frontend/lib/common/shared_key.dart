enum SharedKey {
  USERNAME,
  EMAIL,
  AUTH_TOKEN,
  PEOPLE_ID
}

extension ParseToString on SharedKey {
  String toShortString() {
    return this.toString().split('.').last;
  }
}