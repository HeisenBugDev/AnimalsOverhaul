package mods.ao.core;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;

public class VanillaSpawnPreventer {
	private static final ArrayList<Class> blockedSpawns = new ArrayList<Class>(4);
	
	static{
		blockedSpawns.add(EntityChicken.class);
		blockedSpawns.add(EntityCow.class);
		blockedSpawns.add(EntityPig.class);
		blockedSpawns.add(EntitySheep.class);
	}
	
	@ForgeSubscribe
	public void preventVanillaSpawns(CheckSpawn spawn){
		Entity spawned = spawn.entity;
		if(spawned instanceof EntityAnimal){
			Class animalClass = spawned.getClass();
			if(blockedSpawns.contains(animalClass)){
				spawn.setResult(Result.DENY);
			}
		}
	}
}
