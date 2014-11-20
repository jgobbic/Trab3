/** Trabalho 02 - Programação Orientada a Objeto - Engenharia de Computação - Main
 Feito por João Pedro Gobbi Codognotto - 8504347
 Linguagem Java
**/
import Item.*;

public class Game{
	public static void main (String args[]){
	
	//CHARS//
		System.out.println("\nCriando char1 \n");
		
		Knight char1 = new Knight("Orc Warrior",2);
		char1.setStrenght(30);
		char1.setDexterity(30);
		char1.setSpeed(10);
		char1.setConstitution(10);
		char1.earnGold(0);
		char1.setSpaces(5);
		char1.addXP(2);
		char1.addPower(10);
		
	
		System.out.println("\nCriando char2 \n");
	
		Knight char2 = new Knight("Orc Berseker",10);
		char2.setStrenght(50);
		char2.setDexterity(30);
		char2.setSpeed(10);
		char2.setConstitution(10);
		char2.earnGold(0);
		char2.setSpaces(5);
		char2.addXP(2);
		char2.addPower(10);
		
		
		System.out.println("\nCriando char3 \n");
		
		Wizard char3 = new Wizard("Orc Shaman",40);
		char3.setStrenght(10);
		char3.setDexterity(20);
		char3.setSpeed(20);
		char3.setConstitution(10);
		char3.earnGold(0);
		char3.setSpaces(5);
		char3.addXP(2);
		char3.addWisdom(10);
		
		
		System.out.println("\nCriando char4 \n");
		
		Thief char4 = new Thief("Orc Warlord",20);
		char4.setStrenght(20);
		char4.setDexterity(20);
		char4.setSpeed(20);
		char4.setConstitution(20);
		char4.earnGold(0);
		char4.setSpaces(5);
		char4.addXP(2);
		char4.addStealth(10);
		
		
		System.out.println("\nCriando char5 \n");
		
		Knight char5 = new Knight("Wild Warrior",3);
		char5.setStrenght(40);
		char5.setDexterity(20);
		char5.setSpeed(10);
		char5.setConstitution(10);
		char5.earnGold(0);
		char5.setSpaces(5);
		char5.addXP(2);
		char5.addPower(10);
		
	
		System.out.println("\nCriando char6 \n");
	
		Knight char6 = new Knight("Valkyre",5);
		char6.setStrenght(20);
		char6.setDexterity(30);
		char6.setSpeed(10);
		char6.setConstitution(10);
		char6.earnGold(0);
		char6.setSpaces(5);
		char6.addXP(2);
		char6.addPower(10);
		
		
		System.out.println("\nCriando char7 \n");
		
		Wizard char7 = new Wizard("Warlock",80);
		char7.setStrenght(10);
		char7.setDexterity(10);
		char7.setSpeed(20);
		char7.setConstitution(10);
		char7.earnGold(0);
		char7.setSpaces(5);
		char7.addXP(2);
		char7.addWisdom(10);


		System.out.println("\nCriando char8 \n");
		
		Thief char8 = new Thief("Assassin",20);
		char8.setStrenght(20);
		char8.setDexterity(20);
		char8.setSpeed(20);
		char8.setConstitution(20);
		char8.earnGold(0);
		char8.setSpaces(5);
		char8.addXP(2);
		char8.addStealth(10);
		
		
	//ITEMS//
		System.out.println("\nCriando Items \n");
		
		Weapon arm1 = new Weapon("Carlin Sword",2,2,5.0);
		Weapon arm2 = new Weapon("Rapier",1.2,1,1.0);
		Weapon arm3 = new Weapon("Wand of Vortex",1.2,1,3.0);
		Weapon arm4 = new Weapon("Bow",1.2,2,6.0);
		Weapon arm5 = new Weapon("Magic Long Sword",5.2,10,1.0);
		Weapon arm6 = new Weapon("Spike Sword",1.2,4,1.0);
		Weapon arm7 = new Weapon("Moonlight Rod",1.2,3,3.0);
		Weapon arm8 = new Weapon("Fire Axe",1.2,6,1.0);
		Weapon arm9 = new Weapon("Assassins Star",1.2,6,6.0);
		Weapon arm10 = new Weapon("Sudden Death Rune",1.2,10,6.0);
		
		
		
		Armor malha1 = new Armor("Blue Robe",2.3,10,2);
		Armor malha2 = new Armor("Chain Armor",1.3,8,5);
		Armor malha3 = new Armor("Crown Armor",3.3,15,5);
		Armor malha4 = new Armor("Magic Plate Armor",5.3,20,18);
		Armor malha5 = new Armor("Demon Armor",5.3,17,14);
		Armor malha6 = new Armor("Plate Armor",2.3,10,10);
		
		
		HealthPotion pot1 = new HealthPotion("UH",1,99);
		HealthPotion pot2 = new HealthPotion("Exura",0.1,25);
		HealthPotion pot3 = new HealthPotion("IH",0.1,40);
		HealthPotion pot4 = new HealthPotion("Health Potion",0.1,40);
		HealthPotion pot5 = new HealthPotion("Great Health Potion",0.1,80);
		
		ManaPotion potm1 = new ManaPotion("Small Mana Potion",0.1,10);
		ManaPotion potm2 = new ManaPotion("Mana Potion",0.1,20);
		ManaPotion potm3 = new ManaPotion("Great Mana Potion",0.1,50);
		
		
	//TEAMS//
	
		System.out.println("\nCriando Times \n");
		Team t1 = new Team("Orc Fortress Guards",Color.green);
		Team t2 = new Team("Thais Deserted Guards",Color.blue);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
	
	//EQUIPANDO PERSONAGENS
		System.out.println("\nEquipando Personagens \n");
		char1.insertItem(arm1);
		char1.insertItem(malha2);
		char1.insertItem(potm1);
		char1.insertItem(pot1);
		char1.equipWeapon(arm1.getName());
		char1.equipArmor(malha2.getName());
		
		char2.insertItem(arm2);
		char2.insertItem(malha6);
		char2.insertItem(potm2);
		char2.insertItem(pot3);
		char2.equipWeapon(arm2.getName());
		char2.equipArmor(malha6.getName());
		
		char3.insertItem(arm3);
		char3.insertItem(malha1);
		char3.insertItem(potm3);
		char3.insertItem(pot5);
		char3.equipWeapon(arm3.getName());
		char3.equipArmor(malha1.getName());
		
		char4.insertItem(arm5);
		char4.insertItem(malha4);
		char4.insertItem(potm2);
		char4.insertItem(pot3);
		char4.equipWeapon(arm5.getName());
		char4.equipArmor(malha4.getName());
	
		char5.insertItem(arm3);
		char5.insertItem(malha2);
		char5.insertItem(potm3);
		char5.insertItem(pot2);
		char5.equipWeapon(arm3.getName());
		char5.equipArmor(malha2.getName());
	
		char6.insertItem(arm8);
		char6.insertItem(arm3);
		char6.insertItem(malha3);
		char6.insertItem(potm2);
		char6.insertItem(pot3);
		char6.equipWeapon(arm8.getName());
		char6.equipWeapon(arm3.getName());
		char6.equipArmor(malha3.getName());
		
		char7.insertItem(arm1);
		char7.insertItem(malha1);
		char7.insertItem(potm1);
		char7.insertItem(pot1);
		char7.equipWeapon(arm1.getName());
		char7.equipArmor(malha1.getName());
		
		
		System.out.println("\nNesse char tenta-se equipar mais de 2 armas e 1 armaduras, alem de adicionar itens alem do tamanho do inventario, erro eh exibido \n");
		
		char8.insertItem(arm2);			//TESTES SE O MAXIMO DE ITENS EQUIPADOS É RESPEITADO
		char8.insertItem(arm3);
		char8.insertItem(arm4);
		char8.insertItem(malha3);
		char8.insertItem(malha4);
		char8.insertItem(potm2);
		char8.insertItem(pot2);
		char8.equipWeapon(arm2.getName());
		char8.equipWeapon(arm3.getName());
		char8.equipWeapon(arm4.getName());
		char8.equipArmor(malha3.getName());
		char8.equipArmor(malha4.getName());
		
		
		//INSERCAO NOS TIMES//
		System.out.println("\nAdicionando aos Times \n");
		t1.addChar(char1);
		t1.addChar(char2);
		t1.addChar(char3);
		t1.addChar(char4);
		
		t2.addChar(char5);
		t2.addChar(char6);
		t2.addChar(char7);
		t2.addChar(char8);
		
		//TESTES DE BATALHA
		System.out.println("\nRodada 1 da batalha \n");
		//Rodada 1
		char1.attackCharacter(char5);
		char5.attackCharacter(char1);
		char2.attackCharacter(char6);
		char6.attackCharacter(char2);
		char3.attackCharacter(char7);
		char7.attackCharacter(char3);
		char4.attackCharacter(char8);
		char8.attackCharacter(char4);
		
		System.out.println("\nResultados \n");
		
		t1.resolveBattle(t2);
		t2.resolveBattle(t1);

		//Rodada 2
		System.out.println("\n Fim da primeira Rodada \n");
		System.out.println("\nUsa-se uma pocao, tenta-se usar ela novamente, porem ela foi deletada, entao ela eh buscada no inventario \n");
		
		char2.usePotion(pot3.getName()); //TESTE DAS POÇÔES
		char2.usePotion(pot3.getName()); //TESTE DAS POÇÔES
		char2.searchItem(pot3.getName());

		System.out.println("\nComeco da segunda rodada\n");
		
		char8.attackCharacter(char4);
		char4.attackCharacter(char8);
		char7.attackCharacter(char3);
		char3.attackCharacter(char7);
		char6.attackCharacter(char1);
		char2.attackCharacter(char6);
		char5.attackCharacter(char2);
		char1.attackCharacter(char5);
		
		t1.resolveBattle(t2);
		t2.resolveBattle(t1);
		System.out.println("\nResultados finais\n");
		System.out.println(t1.getResults() + "\n" + t2.getResults());
		
		}
}
	