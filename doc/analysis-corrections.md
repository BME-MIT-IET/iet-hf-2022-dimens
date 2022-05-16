# SonarCloud és manuális kódátvizsgálás

## SonarCloud

A SonarCloud-hoz való hozzáféréshez adminisztrátor jogot kellett kérnünk, miután ezt megkaptuk, elkezdtük felconfigolni.
Idõközben rájöttünk, hogy elnéztük, és másik felhasználó kapott admin jogot, mint amire mi számítottunk. Ezután a
félreértés után már gördülékenyen ment a felconfigolás, kiegészítettünk a `pom.xml` és `maven.yml` fájlokat.

A SonarCloud felülete kijelezte a hibákat, amikbõl javítottunk párat. Minden pusholáskor a GitHub Actions mellett a
SonarCloud kiértékelõje is lefutott a GitHub felületén.

## Manuális kódátvizsgálás

