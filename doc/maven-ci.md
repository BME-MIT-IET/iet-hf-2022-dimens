# Maven és GitHub Actions beüzemelése

## Maven

A fejlesztõeszközként használt Intellij IDEA alapértelmezetten létrehozott egy `pom.xml` vázat,
amit kiegészítettünk a projekt információkkal, valamint az egységtesztelés és statikus analízishez
szükséges `property`-kkel és `dependency`-kkel. Alapvetõen automatizált volt a folyamat, kevés
szöveget kellett kézzel írnunk.

Rendkívül kényelmes, hogy a projekt tulajdonságait és importjait egy helyen lehet tartani,
és egy szimpla paranccsal érvényre juttatni.

## GitHub Actions

A GitHub felületén hozzá lehetett adni az Actions-t a projektünkhöz, ami (a Maven opció kiválasztása után) 
automatikusan létrehozta a `.github/workflows/maven.yml` fájlt, ami az Actions számára biztosítja az utasításokat.
Ezt késõbb a SonarCloud beüzemeléséhez kellett szerkesztenünk. 


Ha több eszköz állt volna a rendelkezésünkre, akkor szerteágazóbb automatikus ellenõrzéseket tudtunk volna létrehozni
az Actions segítségével. Mivel az Actions minden push után lefut, ezért meg tudunk bizonyosodni,
hogy a program fõbb funkciói még mindig helyesen mûködnek.