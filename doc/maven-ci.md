# Maven �s GitHub Actions be�zemel�se

## Maven

A fejleszt�eszk�zk�nt haszn�lt Intellij IDEA alap�rtelmezetten l�trehozott egy `pom.xml` v�zat,
amit kieg�sz�tett�nk a projekt inform�ci�kkal, valamint az egys�gtesztel�s �s statikus anal�zishez
sz�ks�ges `property`-kkel �s `dependency`-kkel. Alapvet�en automatiz�lt volt a folyamat, kev�s
sz�veget kellett k�zzel �rnunk.

Rendk�v�l k�nyelmes, hogy a projekt tulajdons�gait �s importjait egy helyen lehet tartani,
�s egy szimpla paranccsal �rv�nyre juttatni.

## GitHub Actions

A GitHub fel�let�n hozz� lehetett adni az Actions-t a projekt�nkh�z, ami (a Maven opci� kiv�laszt�sa ut�n) 
automatikusan l�trehozta a `.github/workflows/maven.yml` f�jlt, ami az Actions sz�m�ra biztos�tja az utas�t�sokat.
Ezt k�s�bb a SonarCloud be�zemel�s�hez kellett szerkeszten�nk. 


Ha t�bb eszk�z �llt volna a rendelkez�s�nkre, akkor szerte�gaz�bb automatikus ellen�rz�seket tudtunk volna l�trehozni
az Actions seg�ts�g�vel. Mivel az Actions minden push ut�n lefut, ez�rt meg tudunk bizonyosodni,
hogy a program f�bb funkci�i m�g mindig helyesen m�k�dnek.