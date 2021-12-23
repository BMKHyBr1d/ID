<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:strip-space elements="*" />
    <xsl:template match="jogadores">
        <listagem>
            <xsl:apply-templates select="jogador">
                <xsl:sort select="ranking[@tipo='global']" order="descending"/>
            </xsl:apply-templates>
        </listagem>
    </xsl:template>
    <xsl:template match="jogador">
    <xsl:if test="not(contains(ranking[@tipo='global'],'Ranking não encontrado'))">
        <xsl:value-of select="nomec"/>
	<xsl:text>&#x3000;</xsl:text>
        <xsl:value-of select="ranking[@tipo='global']"/>
	<xsl:text>&#xa;</xsl:text>
	</xsl:if>
    </xsl:template>
    
</xsl:stylesheet>
