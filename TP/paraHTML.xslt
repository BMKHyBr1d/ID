<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="jogadores">
<html><body><table border="1">
<tr><th>Nome</th><th>Fotografia</th></tr>
<xsl:apply-templates select="jogador"/>
</table>
</body></html>
</xsl:template>
<xsl:template match="jogador">
	<tr>
		<td><xsl:value-of select="nomec"/></td>
		<td><img src="{foto}" width="75" height="100" /></td>
	</tr>
</xsl:template>
</xsl:stylesheet>
