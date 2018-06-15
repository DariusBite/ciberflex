package utils;

import javax.swing.JComboBox;

public class Lugares {
	
	public static String[] provincias = {
/*0	*/	"",
/*1	*/	"Amazonas",
/*2	*/	"Áncash",
/*3	*/	"Apurímac",
/*4	*/	"Arequipa",
/*5	*/	"Ayacucho",
/*6	*/	"Cajamarca",
/*7	*/	"Callao",
/*8	*/	"Cusco",
/*9	*/	"Huancavelica",
/*10*/	"Huánuco",
/*11*/	"Ica",
/*12*/	"Junín",
/*13*/	"La Libertad",
/*14*/	"Lambayeque",
/*15*/	"Lima",
/*16*/	"Loreto",
/*17*/	"Madre de Dios",
/*18*/	"Moquegua",
/*19*/	"Pasco",
/*20*/	"Piura",
/*21*/	"Puno",
/*22*/	"San Martín",
/*23*/	"Tacna",
/*24*/	"Tumbes",
/*25*/	"Ucayali"
	};
	
	public static String[][] ciudades = {
/*0*/	{""},
/*1 */	{"", "Bagua Grande", "Chachapoyas","Bagua"}, 
/*2 */	{"", "Chimbote", "Nuevo Chimbote", "Huaraz", "Casma", "Huarmey"},
/*3 */	{"", "Abancay", "Andahuaylas"},
/*4 */	{"", "Arequipa", "Mollendo", "Camaná"},
/*5 */	{"", "Ayacucho", "Huanta"},
/*6 */	{"", "Cajamarca", "Jaén", "Cutervo", "Chota", "Bambamarca"},
/*7 */	{"", "Callao"},
/*8 */	{"", "Cusco", "Sicuani", "Quillabamba", "Espinar"},
/*9 */	{"", "Huancavelica"},
/*10*/	{"", "Huánuco",	"Tingo María"},
/*11*/	{"", "Ica",	"Chincha Alta", "Pisco", "Nasca"},
/*12*/	{"", "Huancayo", "Tarma", "Jauja", "La Oroya"},
/*13*/	{"", "Trujillo", "Chepén", "Pacasmayo", "Guadalupe", "Casa Grande"},
/*14*/	{"", "Chiclayo", "Lambayeque", "Ferreñafe", "Monsefú"},
/*15*/	{"", "Lima", "Huacho", "Huaral", "Cañete", "Barranca", "Chancay", "Paramonga"},
/*16*/	{"", "Iquitos",	"Yurimaguas", "Requena"},
/*17*/	{"", "Puerto Maldonado"},
/*18*/	{"", "Moquegua", "Ilo"},
/*19*/	{"", "Cerro de Pasco"},
/*20*/	{"", "Piura", "Sullana", "Paita", "Talara", "Catacaos", "Chulucanas", "Sechura"},
/*21*/	{"", "Juliaca",	"Puno",	"Azángaro"},
/*22*/	{"", "Tarapoto", "Moyobamba", "Juanjuí", "Rioja"},
/*23*/	{"", "Tacna"},
/*24*/	{"", "Tumbes", "Zarumilla"},
/*25*/	{"", "Pucallpa"}
	};
	
	public static String[] setCiudades(int i){
		return ciudades[i];
	};

}
