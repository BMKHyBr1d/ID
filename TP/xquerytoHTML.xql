xquery version "1.0";

<html><body>
<h1>Jogadores Pé preferido:Direito </h1>
<ul>

{

for $x in doc("C:\Users\HyBr1d\Desktop\Faculdade\TP\jogador.xml")//jogador
where contains($x/pepref,'direito')
order by $x/nomec
return <li>($x/titulo/text())</li>

}
</ul>
</body>
</html>
