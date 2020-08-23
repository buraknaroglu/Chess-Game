# Chess Game Api

Projemiz, santranç oyunundaki vezirin ulaşabileceği noktaların hesabını yapar. 

# Projede Kullanılan Teknolojiler 

- Projemiz Spring Boot Mvc projesidir.
- Rest Api'mizi dökümante edebilmek amaci ile swagger kullanilmistir.
- Ekstra olarak projenin build edilmesi icin Dockerfile eklenmiştir.
- Junit
- Maven

# Projenin Build Edilmesi

Projenin İntellij idea araciliyla build islemi:

  Projeyi Github'dan bilgisayarimizi indirdikten sonra İntellij idea acilir ve File->New->Module From Existing Source tıklanir ve projenin   oldugu dizin gosterilir. Maven secilir ve next'e basilarak proje eklenmis olur. Edit configuration acilir ve Spring Boot secilir main class olarak TicketApplication.java class' inin oldugu path verilir. JRK olarakta 11 (ve üzeri) secilir ve run edilir.
  
Projenin Docker araciliyla build islemi:  

  Asagidaki iki komut calistirilir ve projemizin build olaracaktir.
  - docker build -f Dockerfile -t chess .
  - docker run -p 8080:8080 chess
  

# Code Coverage

    Package	Class,    %	        Method,          %    Line, %
    all classes	100% (1/ 1)	100% (14/ 14)	100% (112/ 112)
    
    Coverage Breakdown
    Package	Class,                  %	        Method, %	Line, %
    com.chess.game.controller	100% (1/ 1)	100% (14/ 14)	100% (112/ 112)
  

# Servisler

    Question 1
    
    * http://localhost:8080/chess/question-1 (POST) -> Koordinatları verilen santraç masasında vezirin gidebileceği noktaları hesaplar.
    
        * Request -> {
                       "coordinate": {
                         "x": 4,
                         "y": 4
                       },
                       "n": 8
                     }
                     
        * Response -> 27            
    
    
    Question 2
    
    * http://localhost:8080/chess/question-2 (POST) -> Koordinatları verilen santraç masasında engel konulan noktaları göz önünde bulundurarak vezirin gidebileceği noktaları hesaplar.
        
        * Response -> {
                        "coordinate": {
                          "x": 4,
                          "y": 4
                        },
                        "kCoordinates": [
                          {
                            "x": 5,
                            "y": 3
                          }
                        ],
                        "n": 8
                      }
        * Response -> 24                 
                      
    








