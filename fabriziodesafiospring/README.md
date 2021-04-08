# Articles API fabrizio fernandez

**Endpoints Disponibles:** https://docs.google.com/document/d/1Q9raZkxc_ShAHuVNwFc6Pxke_cDFhrtXyqt4zJGvX7Q/edit

> Aclaracion:

La implementacion actual puede soportar muchos mas filtros al mismo tiempo en el endpoint **GET /api/v1/articles**
Se **limito la implementacion** a 2 filtros y se interpreto de la consigna que tambien se puede aplicar un solo filtro.


# Archivos

El archivo de base de datos se encuentra en el directorio principal del proyecto en **CSV/articles.csv**

En caso de necesitar descargar el archivo nuevamente, el mismo se puede descargar directamente desde aqui: https://docs.google.com/spreadsheets/d/1tpEjvsIrDp7ivOEUV-asbOut8UOT5YwRdTHRguUh6To/edit#gid=0

## Librerias externas utilizadas

Se implemento en la capa repository la libreria **OpenCSV** http://opencsv.sourceforge.net/
Se utiliza para marcar los campos de la clase `Article` como columnas del csv, y al cargar el archivo mapea automaticamente a una `List<Article>`



# Beta continuo

- Quedo una logica metida en el constructor de `ArticleDTO` que debe ir en otro lado seguramente.
- El path al archivo **articles.csv** quedo hardcodeado como una constante en la clase `ArticleRepositoryImpl`
- El **ticketId** recibido al completar una compra siempre es `123`, falta implementar una mejor solucion.

# Notas del desarrollador:
El metodo que mas me costo fue
`List<ArticleDTO> filter(List<ArticleDTO> articles, String key, String value)`
De la clase `ArticleServiceImpl`
Utilice reflection para poder armar metodos dinamicamente sumando "get" a los nombres de las variables recibidas por parametro desde el endoint **GET /api/v1/articles**

