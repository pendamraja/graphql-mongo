# graphql-mongo
Spring boot with graphql mongodb database

For testing use postman

To insert data into mongoDB

http://localhost:8080/BookStore/v1/insertbooks

{
    "id": 8003,
    "name": "Java World",
     "author":{
         "id":"1000",
         "name": "MiTASHI",
         "age": "29" 
     },
    "publisher": "cinema publisher",
    "publishedDate": "04/02/2012"
}

http://localhost:8080/BookStore/v1

{
    findallBooks {
        id
        name
        author{
            id
            name
            age
        }
        publisher
        publishedDate
    }
}


http://localhost:8080/BookStore/v1
{
    findbook(id:"8002") {
        id
        name
        author{
            id
            name
        }
        publisher
        publishedDate
      }
}
http://localhost:8080/BookStore/v1
{
    findbookByname(name:"Java World") {
    name
    author {
        name
        age
        id
    }
       }
}
