<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:strip-space elements="*" />
    <xsl:template match="jogadores">
        <listagem>
            <xsl:apply-templates select="jogador">
                <xsl:sort select="altura" order="descending"/>
            </xsl:apply-templates>
        </listagem>
    </xsl:template>
    <xsl:template match="jogador">
<xsl:if test="not(contains(altura,'Altura não encontrada'))">
        <xsl:value-of select="nomec"/>
	<xsl:text>&#x3000;</xsl:text>
        <xsl:value-of select="altura"/>
	<xsl:text>&#xa;</xsl:text>
</xsl:if>
    </xsl:template>
    
</xsl:stylesheet>
