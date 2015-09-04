package com.mrburger.PowerArmorMod.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTest extends EntityThrowable {

    private float explosionRadius = 1.0F;

    public EntityTest(World par1World) {
        super(par1World);
        setSpeed();
    }

    public EntityTest(World par1World, EntityPlayer par2EntityLiving) {
        super(par1World, par2EntityLiving);
        setSpeed();
    }

    public EntityTest(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        setSpeed();
    }

    private void setSpeed() {
//    	this.motionX*=3;
//    	this.motionY*=3;
//    	this.motionZ*=3;

        setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingobjectposition) {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius, true);
        this.setDead();
    }
}
