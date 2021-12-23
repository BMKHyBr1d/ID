xquery version "1.0";
<queryResult>
{

for $x in doc("C:/Users/HyBr1d/Desktop/Faculdade/TP/jogador.xml")//jogador
let $v:= doc("C:/Users/HyBr1d/Desktop/Faculdade/TP/clube1.xml")/clube
where contains($x/clube,$v)
order by $x/nomec
return 

<nomec>{$x/nomec/text()}</nomec>

}
</queryResult>
