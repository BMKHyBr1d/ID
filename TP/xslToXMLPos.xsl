<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="jogadores">
        <listagem>
            <xsl:apply-templates select="jogador">
                <xsl:sort select="nomec"/>
            </xsl:apply-templates>
        </listagem>
    </xsl:template>
    <xsl:template match="jogador">
    <xsl:if test = "clube='---'">
        <xsl:value-of select="nomec"/>
    </xsl:if>
    </xsl:template>
</xsl:stylesheet>
