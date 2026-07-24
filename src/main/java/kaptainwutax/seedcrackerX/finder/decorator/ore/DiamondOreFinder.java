package kaptainwutax.seedcrackerX.finder.decorator.ore;

import kaptainwutax.seedcrackerX.finder.Finder;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import java.util.List;

public class DiamondOreFinder extends OreFinder {

    public DiamondOreFinder(World world, ChunkPos chunkPos) {
        super(world, chunkPos, List.of(
            Blocks.DIAMOND_ORE,
            Blocks.DEEPSLATE_DIAMOND_ORE
        ));
    }

    @Override
    public FinderType getType() {
        return FinderType.ORE;
    }

    @Override
    public List<BlockPos> findInChunk() {
        return super.findInChunk();
    }
}
