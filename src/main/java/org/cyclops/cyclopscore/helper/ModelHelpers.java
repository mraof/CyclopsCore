package org.cyclops.cyclopscore.helper;

import com.google.common.base.Charsets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Helpers for models.
 * @author rubensworks
 */
public final class ModelHelpers {

    /**
     * Read the given model location to a {@link net.minecraft.client.renderer.block.model.ModelBlock}.
     * @param modelLocation A model location (without .json suffix)
     * @return The corresponding model.
     * @throws IOException If the model file was invalid.
     */
    public static ModelBlock loadModelBlock(ResourceLocation modelLocation) throws IOException {
        IResource resource = Minecraft.getMinecraft().getResourceManager().getResource(
                new ResourceLocation(modelLocation.getResourceDomain(), modelLocation.getResourcePath() + ".json"));
        Reader reader = new InputStreamReader(resource.getInputStream(), Charsets.UTF_8);
        return ModelBlock.deserialize(reader);
    }

}
