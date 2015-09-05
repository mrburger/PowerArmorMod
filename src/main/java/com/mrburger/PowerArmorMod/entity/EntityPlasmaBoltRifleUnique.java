package com.mrburger.PowerArmorMod.entity;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntityPlasmaBoltRifleUnique extends EntityThrowable {



    public EntityPlasmaBoltRifleUnique(World world) {
        super(world);
    }

    public EntityPlasmaBoltRifleUnique(World par1World, double arg1Double, double arg2Double, double arg3Double) {
        super(par1World, arg1Double, arg2Double, arg3Double);
    }

    public EntityPlasmaBoltRifleUnique(World par1World, EntityLivingBase arg1EntityLivingBase) {
        super(par1World, arg1EntityLivingBase);
    }




    @Override
    protected void onImpact(MovingObjectPosition movingPos) {
        if (movingPos.entityHit != null) {
            float plasma = 10;

            movingPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), plasma);
            worldObj.spawnParticle("magicCrit", posX, posY, posZ, 0.0F, 0.0F, 0.0F);

        }
        worldObj.spawnParticle("largesmoke", posX, posY, posZ, 0.0F, 0.0F, 0.0F);
        this.setDead();
    }
    @Override
    protected float getGravityVelocity()
    {
        return 0;

    }
    private void setSpeed()
    {
        setThrowableHeading(this.motionX, this.motionY, this.motionZ, 0.1F, 1.0F);
    }



}