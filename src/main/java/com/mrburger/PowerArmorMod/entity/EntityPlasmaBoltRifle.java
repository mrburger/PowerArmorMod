package com.mrburger.PowerArmorMod.entity;

import com.mrburger.PowerArmorMod.item.model.ModelPlasmaBolt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Map;

public class EntityPlasmaBoltRifle extends EntityThrowable {
    private int speedProjectile = 1;


    public EntityPlasmaBoltRifle(World par1World) {
        super(par1World);
    }

    public EntityPlasmaBoltRifle(World par1World, double arg1Double, double arg2Double, double arg3Double) {
        super(par1World, arg1Double, arg2Double, arg3Double);
    }

    public EntityPlasmaBoltRifle(World par1World, EntityLivingBase arg1EntityLivingBase) {
        super(par1World, arg1EntityLivingBase);
    }


    @Override
    protected void onImpact(MovingObjectPosition movingPos) {
        if (movingPos.entityHit != null) {
            float plasma = 20;

            movingPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), plasma);
        }
        this.setDead();
    }
    @Override
    protected float getGravityVelocity()
    {
        return 0;

    }
    private void setSpeed()
    {
        setThrowableHeading(this.motionX, this.motionY, this.motionZ, 1.0F, 1.0F);
    }



}