<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text"/>
<xsl:template match="jogadores">
	<xsl:text>Todos os Jogadores</xsl:text>
	<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="jogador">
	<xsl:if test="nacionalidade='Portugal'">
	<xsl:value-of select="nomec"/>
	</xsl:if>
	</xsl:template>
</xsl:stylesheet>
