<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="jogadores">
		<jogadores>
			<xsl:for-each select="jogador">
				<xsl:sort select="valor" order="descending"/>
				<xsl:if test="not(contains(valor,'Valor não encontrado'))">
					<xsl:if test="position() &lt; 8">
						<jogador>
							<nome>
								<xsl:value-of select="@nome"/>
							</nome>
							<preco>
								<xsl:value-of select="valor"/>
							</preco>
						</jogador>
					</xsl:if>
				</xsl:if>
			</xsl:for-each>
		</jogadores>
	</xsl:template>
</xsl:stylesheet>