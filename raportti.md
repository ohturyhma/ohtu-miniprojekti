# Raportti

Miniprojektin toteutukseen osallistuivat Susanna Rajamäki, Roope Niemi, Vertti Viitanen ja Johannes Hyry.

## 1. sprintti

Alussa hankalinta oli selvittää käytetyt tekniikat tiimin kesken. Pohdintaa oli paljon mm. tietokantatoteutuksen ympärillä. JPA-tyyppisen rajapinnan käyttäminen tietokantatoteutuksena olisi ollut ideaali, mutta rajoitetun työajan takia ei jäänyt aikaa sen selvittämiseksi, että miten sen olisi saanut konfiguroitua toimivalla tavalla. Tämä olisi ollut hyvä saada toimimaan sillä DAO-toteutuksen, jota ryhmä päätyi käyttämään, refaktorointi osoittautui myöhemmin ajoittain hankalaksi. Lisäksi gradle oli tiimille uusi buildaustyökalu, jonka käytössä tuli pieniä virheitä alussa, joiden korjaaminen jäi seuraavaan viikoon. Jacocon kanssa oli rivikattavuuden kanssa näkyvyysongelmia, jotka korjattiin seuraavan sprintin alussa.

Projektityöskentelyssä backlogin käyttö oli uutta, joten alussa ei onnistuttu pilkkomaan user storyja oikealla tavalla tarpeeksi pieniksi teknisiksi taskeiksi. Toisena projektityöskentelyn haasteena oli ymmärtää minkä verran dokumentaatioon ja suunnitteluun kuuluu varata resursseja.

Ensimmäisen sprintin loppupuolella yksi ryhmän jäsenistä ilmoitti, että keskeyttää kurssin eikä osallistu projektiin. Se aiheutti hiukan haasteita tehtävien uudelleenjakamisen suhteen, mutta ei ylitsepääsemättömiä ongelmia, koska hän ilmoitti asiasta hyvissä ajoin ennen sprintin päättymistä.

## 2. sprintti

Toisessa sprintissä sprintin suunnittelupalaveri osattiin toteuttaa selvästi hyödyllisemmin kuin ensimmäisellä sprintillä. Ryhmän työskentely yhdessä alkoi sujua.

Käyttöliittymää muokattiin uuteen uskoon mm. lisäämällä IO-rajapinta, jotta Cucumber-testien tekeminen onnistuisi helpommin. 

Tekstipohjainen käyttöliittymä rupesi jo alussa tuntumaan turhan paisuneelta ja se toimi liikaa if-lauseiden varassa. Toisteisuutta oli paljon. Tässä vaiheessa alkoi tulla selväksi DAO-luokkien refaktoroinnin vaikeus. 
Cucumber oli kaikille uusi asia ja sen testien saaminen toimimaan tekstikäyttöliittymän kanssa oli hieman haastavaa. 

## 3. sprintti

Projektityöskentely parani yleisesti ottaen entisestään, mutta yksi tiimiläinen, joka ei päässyt sprintin suunnittelupalaveriin, koki haastavaksi osallistua projektin edistämiseen yhteisen vision mukaisesti.

Teknisinä haasteina oli Cucumberin muokkaaminen geneerisemmäksi ja tekstikäyttöliittymän mukaiseksi. Tässä vaiheessa rupesi tulla selväksi, että tekstikäyttöliittymä ja Cucumber-testit olisi hyvä suunnitella jo alussa tiettyyn pisteeseen asti. Käyttöliittymän muokkaaminen kun saattoi aiheuttaa useamman Cucumber-testin hajoamisen. Lisäksi yksi haaste oli, että joissain Cucumber testeissä oletettiin, että tietokannassa on jotain tavaraa jo valmiiksi, jotta olisi voitu testata hyväksyttyjä tietokantahakuja ja niiden tulostusta. Tähän piti kehittää muutaman apumetodin avulla keino, jolla jo Given-vaiheessa tietokantaan luodaan dataa, jotta When- ja Then-vaiheessa voidaan testata onnistunutta
hakua. Lisäksi piti keksiä jokin keino, jossa jokaisen testin jälkeen tietokanta tyhjennettäisiin. Tämän olisi ilmeisesti voinut tehdä jotenkin annotaatioilla, mutta ei ollut aikaa perehtyä keinoihin. Ratkaisuksi päädyttiin kovakoodaamaan tietokannan tyhjentämisen ja sinne lisäämisen ennen hakua, jotta viikkotyöaikoija ei ylitettäisi.

Oikeiden URL-tunnisteiden hyväksymiseksi päädyttiin tekemään oma pattern match, koska se oli nopeampaa kuin tarpeeksi hyvän valmiin ratkaisun etsiminen.

## 4. sprintti

Projektityöskentely parantui sprinttien edetessä. Alussa oli aikamoista hakuammuntaa, mutta se parani viikko viikolta.

App-luokan refaktorointi oli aikaa vievää, mutta ei teknisesti haastavaa.

Backlogin ylläpidossa oli edelleen parantamisen varaa, vaikka loppua kohden se oli parempaa kuin alussa. 

Tietokantatoteutus olisi ollut hyvä saada paremmaksi käyttämällä jotain valmista ratkaisua, esimerkiksi mainittua JPA-tyyppistä ratkaisua (esim. Hibernate). Kyseinen ratkaisutapa vähentäisi refaktoroinnin ja muun koodin ylläpidon tarvetta, lyhentäisi koodia huomattavasti ja tekisi siitä paljon selkeämpää kuin nykyinen ratkaisu.

Ennen demoesitystä ohjelman kanssa tehtiin ratkaisuja, joiden takia testikattavuus romahti täysin. Testikattavuuden paikkaaminen oli oleellinen viime hetkellä tullut tehtävä.

## Loppusanat

Ryhmälle uusia teknisiä asioita olivat: gradle, cucumber ja travis. Cucumber tuntui ajoittain turhalta, koska jos olisi tätä isompi projekti, jossa integraatio- ja yksikkötestit olisivat kattavia, niin Cucumber tuntui olevan vain yksi ylimääräinen kerros, joka tekee saman asian kuin jo olemassa olevat testit.

Projektin aikana alkoi hahmottaa sprinttien toimintatapaa ja myös sitä miten kannattaa ja varsinkin miten ei kannata työskennellä. Oli sääli, että projekti loppui juuri siinä vaiheessa, kun projektityöskentely alkoi sujua.
