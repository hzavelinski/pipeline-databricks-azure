// Databricks notebook source
// MAGIC %md
// MAGIC Conferindo se os dados foram montados e se temos acesso a pasta inbound

// COMMAND ----------

display(dbutils.fs.ls("mnt/dados/inbound"))

// COMMAND ----------

// MAGIC %md
// MAGIC ### Lendo os dados na camada de inbound

// COMMAND ----------

val path = "dbfs:/mnt/dados/inbound/dados_brutos_imoveis.json"
val dados = spark.read.format("json").load(path)

// COMMAND ----------

display(dados)

// COMMAND ----------

val dados_anuncio = dados.drop("Imagens","usuario")
display(dados_anuncio)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Criando um coluna de identificação

// COMMAND ----------

import org.apache.spark.sql.functions.col

// COMMAND ----------

val df_bronze = dados_anuncio.withColumn("id",col("anuncio.id"))
display(df_bronze)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Salvando na camada bronze

// COMMAND ----------

val path = "dbfs:/mnt/dados/bronze/dataset_imoveis"
df_bronze.write.format("delta").mode("overwrite").save(path)
