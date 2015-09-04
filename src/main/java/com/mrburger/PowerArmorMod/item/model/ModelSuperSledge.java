// Date: 9/3/2015 11:42:33 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.mrburger.PowerArmorMod.item.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSuperSledge extends ModelBase
{
  //fields
    ModelRenderer HiltBase;
    ModelRenderer Handle;
    ModelRenderer FlangePiece;
    ModelRenderer Flange2;
    ModelRenderer WeirdThing;
    ModelRenderer SledgeBase;
    ModelRenderer SledgeBody;
    ModelRenderer Sledge2;
    ModelRenderer Sledge1;
    ModelRenderer SledgeConnect2;
    ModelRenderer SledgeConnect1;
  
  public ModelSuperSledge()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      HiltBase = new ModelRenderer(this, 56, 29);
      HiltBase.addBox(-0.5F, 0F, -0.5F, 2, 1, 2);
      HiltBase.setRotationPoint(0F, 0F, 0F);
      HiltBase.setTextureSize(64, 32);
      HiltBase.mirror = true;
      setRotation(HiltBase, 0F, 0F, 0F);
      Handle = new ModelRenderer(this, 60, 0);
      Handle.addBox(0F, -15F, 0F, 1, 15, 1);
      Handle.setRotationPoint(0F, 0F, 0F);
      Handle.setTextureSize(64, 32);
      Handle.mirror = true;
      setRotation(Handle, 0F, 0F, 0F);
      FlangePiece = new ModelRenderer(this, 56, 26);
      FlangePiece.addBox(-0.5F, -15.5F, -0.5F, 2, 1, 2);
      FlangePiece.setRotationPoint(0F, 0F, 0F);
      FlangePiece.setTextureSize(64, 32);
      FlangePiece.mirror = true;
      setRotation(FlangePiece, 0F, 0F, 0F);
      Flange2 = new ModelRenderer(this, 44, 28);
      Flange2.addBox(-1F, 0F, -1F, 3, 1, 3);
      Flange2.setRotationPoint(0F, -16F, 0F);
      Flange2.setTextureSize(64, 32);
      Flange2.mirror = true;
      setRotation(Flange2, 0F, 0F, 0F);
      WeirdThing = new ModelRenderer(this, 0, 26);
      WeirdThing.addBox(-0.5F, -19.5F, -0.5F, 2, 4, 2);
      WeirdThing.setRotationPoint(0F, 0F, 0F);
      WeirdThing.setTextureSize(64, 32);
      WeirdThing.mirror = true;
      setRotation(WeirdThing, 0F, 0F, 0F);
      SledgeBase = new ModelRenderer(this, 8, 28);
      SledgeBase.addBox(-2.5F, -18.32F, -1F, 6, 1, 3);
      SledgeBase.setRotationPoint(0F, 0F, 0F);
      SledgeBase.setTextureSize(64, 32);
      SledgeBase.mirror = true;
      setRotation(SledgeBase, 0F, 0F, 0F);
      SledgeBody = new ModelRenderer(this, 25, 14);
      SledgeBody.addBox(-4F, -23F, -1.5F, 9, 4, 4);
      SledgeBody.setRotationPoint(0F, 0F, 0F);
      SledgeBody.setTextureSize(64, 32);
      SledgeBody.mirror = true;
      setRotation(SledgeBody, 0F, 0F, 0F);
      Sledge2 = new ModelRenderer(this, 0, 16);
      Sledge2.addBox(5.5F, -23.5F, -2F, 1, 5, 5);
      Sledge2.setRotationPoint(0F, 0F, 0F);
      Sledge2.setTextureSize(64, 32);
      Sledge2.mirror = true;
      setRotation(Sledge2, 0F, 0F, 0F);
      Sledge1 = new ModelRenderer(this, 12, 16);
      Sledge1.addBox(-5.5F, -23.5F, -2F, 1, 5, 5);
      Sledge1.setRotationPoint(0F, 0F, 0F);
      Sledge1.setTextureSize(64, 32);
      Sledge1.mirror = true;
      setRotation(Sledge1, 0F, 0F, 0F);
      SledgeConnect2 = new ModelRenderer(this, 0, 6);
      SledgeConnect2.addBox(4.5F, -22.5F, -1F, 1, 3, 3);
      SledgeConnect2.setRotationPoint(0F, 0F, 0F);
      SledgeConnect2.setTextureSize(64, 32);
      SledgeConnect2.mirror = true;
      setRotation(SledgeConnect2, 0F, 0F, 0F);
      SledgeConnect1 = new ModelRenderer(this, 0, 0);
      SledgeConnect1.addBox(-4.5F, -22.5F, -1F, 1, 3, 3);
      SledgeConnect1.setRotationPoint(0F, 0F, 0F);
      SledgeConnect1.setTextureSize(64, 32);
      SledgeConnect1.mirror = true;
      setRotation(SledgeConnect1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    HiltBase.render(f5);
    Handle.render(f5);
    FlangePiece.render(f5);
    Flange2.render(f5);
    WeirdThing.render(f5);
    SledgeBase.render(f5);
    SledgeBody.render(f5);
    Sledge2.render(f5);
    Sledge1.render(f5);
    SledgeConnect2.render(f5);
    SledgeConnect1.render(f5);
  }

  public void renderModel(float f5)
  {
    HiltBase.render(f5);
    Handle.render(f5);
    FlangePiece.render(f5);
    Flange2.render(f5);
    WeirdThing.render(f5);
    SledgeBase.render(f5);
    SledgeBody.render(f5);
    Sledge2.render(f5);
    Sledge1.render(f5);
    SledgeConnect2.render(f5);
    SledgeConnect1.render(f5);
  }



  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }



}