# Behaviour-driven development tesztek

BDD tesztekhez a Cucumber nevû keretrendszert használtuk.
Ez lehetõvé teszi a tesztek deklarálását felhasználói/megrendelõi szemmel.


A keretrendszerhez sok támogatás létezik, melyek
a deklarált tesztekbõl Java kód template-et állítanak össze.
Mivel a csapat az IntelliJ IDE-t használja, ezért ezzel a plugin-nel találkoztunk.

A cucumber nem tartalmaz assertsion/testing keretrendszert, de assertions library-k
pl. JUnit5 integrálhatóak. Mi ezt használtuk hozzá.

Támogatja a Cucumber a tesztek automatukis futtatását (CI).
Ennek felkonfigurálása során jobban bele tudtunk mélyedni a maven használatába.


