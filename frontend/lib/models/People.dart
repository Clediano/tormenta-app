class People {
  final String? id, nome, email, senha;

  People({
    this.id,
    this.nome,
    this.email,
    this.senha,
  });

  factory People.fromJson(Map<String, dynamic> json) {
    return People(
      id: json['id'],
      nome: json['nome'],
      email: json['email'],
      senha: json['senha'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'nome': nome,
      'email': email,
      'senha': senha,
    };
  }
}
