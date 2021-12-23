xquery version "1.0";

(: Generated with EditiX XML Editor (http://www.editix.com) at Sun Jun 06 21:05:55 BST 2021 :)

for $x in doc("C:/Users/HyBr1d/Desktop/Faculdade/TP/jogador.xml")//jogador
where max($x/altura) >= 180
order by $x/nomec
return ("&#10;","JOGADOR:",$x/nomec/text(),"--",max($x/altura))
