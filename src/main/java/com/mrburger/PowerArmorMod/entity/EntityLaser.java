package com.mrburger.PowerArmorMod.entity;

import com.mrburger.PowerArmorMod.world.DamageSourceEnergy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;



public class EntityLaser extends EntityThrowable {


    public EntityLaser(World par1World) {
        super(par1World);
    }

    public EntityLaser(World par1World, double arg1Double, double arg2Double, double arg3Double) {
        super(par1World, arg1Double, arg2Double, arg3Double);
    }

    public EntityLaser(World par1World, EntityLivingBase arg1EntityLivingBase) {
        super(par1World, arg1EntityLivingBase);
    }


    @Override
    protected void onImpact(MovingObjectPosition movingPos) {
        if (movingPos.entityHit != null) {
            float laser = 10;

            movingPos.entityHit.attackEntityFrom(DamageSourceEnergy.energy, laser);

        }
        worldObj.spawnParticle("largesmoke", posX, posY, posZ, 0.0F, 0.0F, 0.0F);
        this.setDead();
    }

    @Override
    protected float getGravityVelocity() {
        return 0;

    }
    @Override
    public void setThrowableHeading(double x, double y, double z, float speed, float deviation)
    {
        speed = 20.0F;
        float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
        x /= f2;
        y /= f2;
        z /= f2;
        x *= speed;
        y *= speed;
        z *= speed;
        motionX = x;
        motionY = y;
        motionZ = z;


    }

}



