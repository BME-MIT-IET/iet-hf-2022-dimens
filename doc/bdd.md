# Behaviour-driven development tesztek

BDD tesztekhez a Cucumber nev� keretrendszert haszn�ltuk.
Ez lehet�v� teszi a tesztek deklar�l�s�t felhaszn�l�i/megrendel�i szemmel.


A keretrendszerhez sok t�mogat�s l�tezik, melyek
a deklar�lt tesztekb�l Java k�d template-et �ll�tanak �ssze.
Mivel a csapat az IntelliJ IDE-t haszn�lja, ez�rt ezzel a plugin-nel tal�lkoztunk.

A cucumber nem tartalmaz assertsion/testing keretrendszert, de assertions library-k
pl. JUnit5 integr�lhat�ak. Mi ezt haszn�ltuk hozz�.

T�mogatja a Cucumber a tesztek automatukis futtat�s�t (CI).
Ennek felkonfigur�l�sa sor�n jobban bele tudtunk m�lyedni a maven haszn�lat�ba.


