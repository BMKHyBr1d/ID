xquery version "1.0";

for $x in doc("C:/Users/HyBr1d/Desktop/Faculdade/TP/jogador.xml")//jogador
let $v:= doc ("C:/Users/HyBr1d/Desktop/Faculdade/TP/nacionalidade.xml")/nacionalidade
where contains($x/nacionalidade,$v)
order by $x/nomec
return ("&#10;","Nome: ",  $x/nomec/text(), " -- ",$x/nacionalidade/text())
