package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivialapp.R
import com.example.trivialapp.model.PreguntasYRespuestas

class MyViewModel: ViewModel() {

    var dificultatEscollida : String by mutableStateOf("FÁCIL")
        private set

    fun canviarDificultat (valor : String) {
        dificultatEscollida = valor
    }


    var quantitatRondes: Int by mutableStateOf(10)
        private set

    fun canviarRondes (valor: Int) {
        quantitatRondes = valor
    }

    var tempsPerRonda : Float by mutableStateOf(20f)
        private set

    fun canviarTemps (valor: Float) {
        tempsPerRonda = valor
    }

    var modeFosc : Boolean by mutableStateOf(false)
        private set

    fun canviarMode (valor: Boolean) {
        modeFosc = valor
        fonsPantalla = if(modeFosc) {
            R.drawable.fonsfosc
        }
        else {
            R.drawable.fonsclar
        }
        colorText = if(modeFosc) {
            Color.White
        }
        else {
            Color.Black
        }

        colorOpcions = if(modeFosc) {
            Color.Cyan
        }
        else {
            Color.Black
        }
    }

    var score : Int by mutableStateOf(0)
        private set

    fun incrementarScore() {
        score++
    }
    fun reiniciarScore() {
        score = 0
    }

    var fonsPantalla = if(modeFosc) {
        R.drawable.fonsfosc
    }
    else {
        R.drawable.fonsclar
    }

    var colorText = if(modeFosc) {
        Color.White
    }
    else {
        Color.Black
    }

    var colorOpcions = if(modeFosc) {
        Color.Cyan
    }
    else {
        Color.Black
    }

}



val questionariFacil = mutableListOf(
    PreguntasYRespuestas.quiz(
        "¿Quién fue el primer presidente de Estados Unidos?",
        mutableListOf(
            "George Washington",
            "Abraham Lincoln",
            "Thomas Jefferson",
            "Benjamin Franklin"),
        "George Washington",
        R.drawable.facil_usa
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se disolvió la Unión Soviética?",
        mutableListOf(
            "1989",
            "1991",
            "1993",
            "1995"),
        "1991",
        R.drawable.facil_urss
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en Suiza?",
        mutableListOf(
            "Alemán",
            "Francés",
            "Italiano",
            "Rumano"),
        "Alemán",
        R.drawable.facil_suiza
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué disciplina deportiva juega Leo Messi?",
        mutableListOf("Fútbol",
            "Tenis",
            "Baloncesto",
            "Golf"),
        "Fútbol",
        R.drawable.facil_messi
    ),
    PreguntasYRespuestas.quiz(
        "¿Dónde se encuentra la Torre de Pisa?",
        mutableListOf(
            "Roma, Italia",
            "Florencia, Italia",
            "Venecia, Italia",
            "Pisa, Italia"),
        "Pisa, Italia",
        R.drawable.facil_pisa
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Indonesia?",
        mutableListOf(
            "Yakarta",
            "Bangkok",
            "Kuala Lumpur",
            "Manila"),
        "Yakarta",
        R.drawable.facil_indonesia
    ),
    PreguntasYRespuestas.quiz(
        "¿Quiénes son los protagonistas de la película 'Pretty Woman'?",
        mutableListOf(
            "Julia Roberts y Richard Gere",
            "Sandra Bullock y Tom Hanks",
            "Jennifer Aniston y Brad Pitt",
            "Angelina Jolie y Johnny Depp"),
        "Julia Roberts y Richard Gere",
        R.drawable.facil_prettywoman
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el río más largo de Europa Occidental?",
        mutableListOf(
            "Río Támesis",
            "Río Rin",
            "Río Sena",
            "Río Danubio"),
        "Río Rin",
        R.drawable.facil_rio
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Francia?",
        mutableListOf(
            "París",
            "Londres",
            "Madrid",
            "Berlín"),
        "París",
        R.drawable.facil_francia
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año comenzó la Segunda Guerra Mundial?",
        mutableListOf(
            "1914",
            "1939",
            "1945",
            "1941"),
        "1939",
        R.drawable.facil_segundaguerra
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién escribió la obra de Romeo y Julieta?",
        mutableListOf(
            "William Shakespeare",
            "Miguel de Cervantes",
            "Charles Dickens",
            "Jane Austen"),
        "William Shakespeare",
        R.drawable.facil_romeoyjulieta
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        mutableListOf(
            "Océano Atlántico",
            "Océano Índico",
            "Océano Pacífico",
            "Océano Ártico"),
        "Océano Pacífico",
        R.drawable.facil_oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el país más grande del mundo por área?",
        mutableListOf(
            "Rusia",
            "Canadá",
            "Estados Unidos",
            "China"),
        "Rusia",
        R.drawable.facil_tierra
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el animal terrestre más grande?",
        mutableListOf(
            "Elefante africano",
            "Jirafa",
            "Rinoceronte blanco",
            "Hipopótamo"),
        "Elefante africano",
        R.drawable.facil_jirafa
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la montaña más alta del mundo?",
        mutableListOf(
            "Monte Everest",
            "Monte Kilimanjaro",
            "Monte McKinley",
            "Monte Aconcagua"),
        "Monte Everest",
        R.drawable.facil_kilimanjaro
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en el mundo?",
        mutableListOf(
            "Inglés",
            "Chino mandarín",
            "Español",
            "Hindi"),
        "Chino mandarín",
        R.drawable.facil_idiomas
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué país se encuentra la Torre Eiffel?",
        mutableListOf(
            "España",
            "Italia",
            "Francia",
            "Alemania"),
        "Francia",
        R.drawable.facil_eiffel
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién pintó La Mona Lisa?",
        mutableListOf(
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Michelangelo"),
        "Leonardo da Vinci",
        R.drawable.facil_monalisa
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se descubrió América?",
        mutableListOf(
            "1492",
            "1942",
            "1462",
            "1789"),
        "1492",
        R.drawable.facil_colon
    ),
    PreguntasYRespuestas.quiz(
        "¿Qué valor tiene la raíz cuadrada de 196?",
        mutableListOf(
            "15",
            "17",
            "16",
            "14"),
        "14",R.drawable.facil_raiz
    )
)

val questionariNormal = mutableListOf(
    PreguntasYRespuestas.quiz(
        "¿Quién formuló la teoría de la evolución por selección natural?",
        mutableListOf(
            "Charles Darwin",
            "Gregor Mendel",
            "Alfred Russel Wallace",
            "Jean-Baptiste Lamarck"),
        "Charles Darwin",
        R.drawable.normal_evolucion
    ),
    PreguntasYRespuestas.quiz(
        "¿De qué país es esta bandera?",
        mutableListOf(
            "Bután",
            "Albania",
            "San Marino",
            "Kenia"),
        "Bután",
        R.drawable.normal_butan
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién descubrió la penicilina?",
        mutableListOf(
            "Isaac Newton",
            "Louis Pasteur",
            "Marie Curie",
            "Alexander Fleming"),
        "Alexander Fleming",
        R.drawable.normal_penicilina
    ),
    PreguntasYRespuestas.quiz(
        "¿Qué elemento ocupa la posición 117 de la Tabla Periódica?",
        mutableListOf(
            "Teneso (Ts)",
            "Oganesón (Og)",
            "Darmstatio (Ds)",
            "Einstenio (Es)"),
        "Teneso (Ts)",
        R.drawable.normal_tablaperiodica
    ),
    PreguntasYRespuestas.quiz(
        "¿Qué juego se llevó el GOTY del año 2011?",
        mutableListOf(
            "The Elder Scrolls V: Skyrim",
            "Batman: Arkham City",
            "Portal 2",
            "Uncharted 3: Drake's Deception"),
        "The Elder Scrolls V: Skyrim",
        R.drawable.normal_goty
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la fórmula del ácido acético?",
        mutableListOf(
            "CH3COOH",
            "CHCOOH",
            "CH2OH",
            "CH3NH2"),
        "CH3COOH",
        R.drawable.normal_acidoacetico
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién escribió 'Crimen y Castigo'?",
        mutableListOf(
            "Fiódor Dostoievski",
            "Alexandre Dumas",
            "Franz Kafka",
            "Nikolai Gógol"),
        "Fiódor Dostoievski",
        R.drawable.normal_crimenycastigo
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?",
        mutableListOf(
            "1776",
            "1789",
            "1804",
            "1812"),
        "1776",
        R.drawable.normal_eeuu
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién escribió 'Berserk'?",
        mutableListOf(
            "Naoki Urasawa",
            "Kentaro Miura",
            "Stephen King",
            "H. P. Lovecraft"),
        "Kentaro Miura",
        R.drawable.normal_berserk
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién compuso 'Las cuatro estaciones'?",
        mutableListOf(
            "Wolfgang Amadeus Mozart",
            "Antonio Vivaldi",
            "Frédéric Chopin",
            "Ludwig van Beethoven"),
        "Antonio Vivaldi",
        R.drawable.normal_cuatroestaciones
    ),
    PreguntasYRespuestas.quiz(
        "¿En la mitología irlandesa, quién portaba la lanza Gáe Bolg?",
        mutableListOf(
            "Scáthach",
            "Cú Chulainn",
            "Lugaid",
            "Diarmuid Ua Duibhne"),
        "Cú Chulainn",
        R.drawable.normal_gaebolg
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál de estas obras de Lovecraft se publicó antes?",
        mutableListOf(
            "Dagón",
            "Azathoth",
            "Nyarlathotep",
            "La llamada de Cthulhu"),
        "Dagón",
        R.drawable.normal_lovecraft
    ),
    PreguntasYRespuestas.quiz(
        "¿Cómo se llama este personaje?",
        mutableListOf(
            "Ed",
            "Edd",
            "Eddy",
            "Dexter"),
        "Ed",
        R.drawable.normal_ed
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién ha vendido más discos?",
        mutableListOf(
            "The Beatles",
            "Michael Jackson",
            "Elvis Presley",
            "Led Zeppelin"),
        "The Beatles",
        R.drawable.normal_discos
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la fórmula matemática del teorema de Pitágoras?",
        mutableListOf(
            "a^2 + b^2 = c^2",
            "a^2 - b^2 = c^2",
            "a + b + c = 0",
            "(a + b)^2 = c^2"),
        "a^2 + b^2 = c^2",
        R.drawable.normal_pitagoras
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Australia?",
        mutableListOf(
            "Canberra",
            "Sídney",
            "Melbourne",
            "Brisbane"),
        "Canberra",
        R.drawable.normal_australia
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el país con la mayor población musulmana del mundo?",
        mutableListOf(
            "Indonesia",
            "Pakistán",
            "Arabia Saudita",
            "Irán "),
        "Indonesia",
        R.drawable.normal_musulman
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el autor de la famosa obra '1984'?",
        mutableListOf(
            "George Orwell",
            "Aldous Huxley",
            "Ray Bradbury",
            "J.R.R. Tolkien"),
        "George Orwell",
        R.drawable.normal_1984
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál de estos procesos es característico de la fotosíntesis?",
        mutableListOf(
            "Ciclo de Krebs",
            "Ciclo de Calvin",
            "Ciclo de la luz",
            "Ciclo de la urea"),
        "Ciclo de Calvin",
        R.drawable.normal_fotosintesis
    ),
    PreguntasYRespuestas.quiz(
        "¿Qué cambio corresponde a una sublimación?",
        mutableListOf(
            "Sólido -> Gaseoso",
            "Gaseoso -> Líquido",
            "Gaseoso -> Plasmático",
            "Líquido -> Gaseoso"),
        "Sólido -> Gaseoso",R.drawable.normal_estadosmateria
    )
)


val questionariDificil = mutableListOf(
    PreguntasYRespuestas.quiz(
        "¿Cuál es la teoría que unifica la relatividad general y la mecánica cuántica?",
        mutableListOf(
            "Teoria de la Reminiscencia",
            "Teoría de la Relatividad",
            "Teoría del Caos",
            "Teoría de Cuerdas"),
        "Teoría de Cuerdas",
        R.drawable.dificil_einstein
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el principio fundamental de la ética deontológica de Immanuel Kant?",
        mutableListOf(
            "Utilitarismo",
            "Imperativo categórico",
            "Ética de la virtud",
            "Consecuencialismo"),
        "Imperativo categórico",
        R.drawable.dificil_kant
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el proceso principal de generación de energía en el sol?",
        mutableListOf(
            "Fusión nuclear",
            "Fisión nuclear",
            "Desintegración radiactiva",
            "Combustión"),
        "Fusión nuclear",
        R.drawable.dificil_sol
    ),
    PreguntasYRespuestas.quiz(
        "¿Cómo se llama este personaje?",
        mutableListOf(
            "Bobobo",
            "Johnny Bravo",
            "Mirror B",
            "Afro Samurai"),
        "Bobobo",
        R.drawable.dificil_bobobo
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se estrenó el primer juego de la franquicia 'The Legend of Zelda'?",
        mutableListOf(
            "1986",
            "1987",
            "1989",
            "1985"),
        "1986",
        R.drawable.dificil_zelda
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se publicó 'Viaje al Oeste'?",
        mutableListOf(
            "1473",
            "1592",
            "1128",
            "1604"),
        "1592",
        R.drawable.dificil_viajealoeste
    ),
    PreguntasYRespuestas.quiz(
        "¿En la serie 'El Príncipe de Bel Air', qué actor interpretaba a Carlton?",
        mutableListOf(
            "James Avery",
            "Will Smith",
            "Joseph Marcell",
            "Alfonso Ribeiro"),
        "Alfonso Ribeiro",
        R.drawable.dificil_belair
    ),
    PreguntasYRespuestas.quiz(
        "¿En el juego de cartas 'Yu-Gi-Oh' qué carta es la contraparte de 'Caído de Albaz'?",
        mutableListOf(
            "Aluber el Bufón de Despia",
            "Albaz de Cenizas",
            "Ecclesia Dogmátik, la Virtuosa",
            "Dramaturgo de Despia"),
        "Aluber el Bufón de Despia",
        R.drawable.dificil_albaz
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el país con menos población del mundo?",
        mutableListOf(
            "Nauru",
            "Palaos",
            "Tuvalu",
            "San Marino"),
        "Tuvalu",
        R.drawable.dificil_poblacion
    ),
    PreguntasYRespuestas.quiz(
        "¿Qué luchador de WWE ha ostentado una mayor cantidad de títulos?",
        mutableListOf(
            "John Cena",
            "Shawn Michaels",
            "Rey Mysterio",
            "R-Truth"),
        "R-Truth",
        R.drawable.dificil_wwe
    ),
    PreguntasYRespuestas.quiz(
        "¿En filosofía, ¿quién desarrolló la teoría del contrato social?",
        mutableListOf(
            "John Locke",
            "Thomas Hobbes",
            "Jean-Jacques Rousseau",
            "Voltaire"),
        "Jean-Jacques Rousseau",
        R.drawable.dificil_contrato
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién desarrolló la teoría de las inteligencias múltiples en psicología?",
        mutableListOf(
            "Sigmund Freud",
            "B. F. Skinner",
            "Howard Gardner",
            "Erik Erikson"),
        "Howard Gardner",
        R.drawable.dificil_intel
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál de estos no es uno de 'Los tres monos sabios' originales?",
        mutableListOf(
            "No ver el mal",
            "No hacer el mal",
            "No oír el mal",
            "No decir el mal"),
        "No hacer el mal",
        R.drawable.dificil_monos
    ),
    PreguntasYRespuestas.quiz(
        "¿Cómo se llama el casco de una armadura samurái?",
        mutableListOf(
            "Kusazuri",
            "Haidate",
            "Mengu",
            "Kabuto"),
        "Kabuto",
        R.drawable.dificil_kabuto
    ),
    PreguntasYRespuestas.quiz(
        "¿En la mitología griega, qué hijo de Loki estaba predestinado a acabar con Odín?",
        mutableListOf(
            "Jormungandr",
            "Ymir",
            "Hela",
            "Fenrir"),
        "Fenrir",
        R.drawable.dificil_nordico
    ),
    PreguntasYRespuestas.quiz(
        "¿Cómo se llama el séptimo avatar de Vishnu en la mitología hindú?",
        mutableListOf(
            "Gautama Buddha",
            "Krishna",
            "Vamana",
            "Rama"),
        "Rama",
        R.drawable.dificil_vishnu
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál de estos Pokémon no es capturable en todas las entregas principales?",
        mutableListOf(
            "Magikarp",
            "Pikachu",
            "Magnemite",
            "Psyduck"),
        "Pikachu",
        R.drawable.dificil_pokemon
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál no es un satélite de Plutón?",
        mutableListOf(
            "Estigia",
            "Caronte",
            "Nix",
            "Galatea"),
        "Galatea",
        R.drawable.dificil_pluton
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año terminó la guerra de los Cien Años?",
        mutableListOf(
            "1243",
            "1337",
            "1453",
            "1474"),
        "1453",
        R.drawable.dificil_guerracien
    ),
    PreguntasYRespuestas.quiz(
        "¿Eu cuál de estos planetas llueve ácido sulfúrico?",
        mutableListOf(
            "Venus",
            "Neptuno",
            "TOI-733b",
            "Marte"),
        "Venus",R.drawable.dificil_sulfurico
    )
)
