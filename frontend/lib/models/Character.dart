class Character {
  final String? id, nome, raca, origem, classe, divindade;
  final int? nivel,
      vidaTotal,
      manaTotal,
      vidaAtual,
      manaAtual,
      deslocamento,
      pontosExperiencia;

  Character({
    this.id,
    this.nome,
    this.raca,
    this.origem,
    this.classe,
    this.divindade,
    this.nivel,
    this.vidaTotal,
    this.manaTotal,
    this.vidaAtual,
    this.manaAtual,
    this.deslocamento,
    this.pontosExperiencia,
  });

  factory Character.fromJson(Map<String, dynamic> json) {
    return Character(
      id: json['id'],
      nome: json['nome'],
      raca: json['raca'],
      origem: json['origem'],
      classe: json['classe'],
      divindade: json['divindade'],
      nivel: json['nivel'],
      vidaTotal: json['vidaTotal'],
      manaTotal: json['manaTotal'],
      vidaAtual: json['vidaAtual'],
      manaAtual: json['manaAtual'],
      deslocamento: json['deslocamento'],
      pontosExperiencia: json['pontosExperiencia'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'nome': nome,
      'raca': raca,
      'origem': origem,
      'classe': classe,
      'divindade': divindade,
      'nivel': nivel,
      'vidaTotal': vidaTotal,
      'manaTotal': manaTotal,
      'vidaAtual': vidaAtual,
      'manaAtual': manaAtual,
      'deslocamento': deslocamento,
      'pontosExperiencia': pontosExperiencia,
    };
  }
}
