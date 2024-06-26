# Projeto de Pipelines de Dados com Airflow e Azure Databricks

Este projeto demonstra a construção de pipelines de dados utilizando Apache Airflow e Azure Databricks para coletar, processar e analisar cotações diárias de câmbio de uma API. Os dados são transformados e salvos em formato Parquet utilizando PySpark, e são enviados relatórios periódicos em formato CSV e gráficos com o histórico das cotações.

## 📝 Visão Geral do Projeto
### Objetivos
1. **Coletar Dados:** Extrair cotações diárias de câmbio de uma API pública e salvar na camada bronze em format parquet.
2. **Processar, Transformar e Armazenar:** Usar Azure Databricks e PySpark para transformar os dados da camada bronze e salvá-los em formato CSV na camada silver.
3. **Envio de Relatórios:** Enviar tabelas em formato CSV e gráficos com o histórico das cotações no slack.
## 🛠️ Tecnologias Utilizadas
* Apache Airflow: Para orquestração e agendamento de tarefas.
* Azure Databricks: Para processamento e transformação de dados.
* PySpark: Para manipulação e transformação dos dados no Databricks.
* API Layer: Fonte dos dados de câmbio diários.
## 🏗️ Arquitetura do Pipeline
* Extração: Uma tarefa no Airflow coleta cotações diárias de câmbio da API Layer.
* Transformação: Os dados brutos são enviados para o Azure Databricks onde são transformados utilizando PySpark e salvos em formato Parquet.
* Carregamento: Os dados transformados são armazenados em um Data Lake ou Data Warehouse.
* Relatórios: Gerar gráficos e tabelas em CSV, e enviá-los como parte dos relatórios.
