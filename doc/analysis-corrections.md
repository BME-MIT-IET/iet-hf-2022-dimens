# SonarCloud és manuális kódátvizsgálás

## SonarCloud

A SonarCloud-hoz való hozzáféréshez adminisztrátor jogot kellett kérnünk, miután ezt megkaptuk, elkezdtük felconfigolni.
Idõközben rájöttünk, hogy elnéztük, és másik felhasználó kapott admin jogot, mint amire mi számítottunk. Ezután a
félreértés után már gördülékenyen ment a felconfigolás, kiegészítettünk a `pom.xml` és `maven.yml` fájlokat.

A SonarCloud felülete kijelezte a hibákat, ezek nagy részét javítottuk. Minden pusholáskor a GitHub Actions mellett a
SonarCloud kiértékelõje is lefutott a GitHub felületén. Az eredeti ~100 code smellt és bugot nagyjából 20-ra csökkentettük.

## Manuális kódátvizsgálás

A kódot manuálisan is átnéztük, de nem igazán találtunk olyan hibákat, amiket a SonarCloud analízise nem mutatott ki.
Leginkább csak néhány kommentet módosítottunk, és néhány helyen átalakítottuk a tördelést. 

