package kaptainwutax.seedcrackerX.finder.decorator.ore;

import kaptainwutax.seedcrackerX.finder.BlockFinder;
import kaptainwutax.seedcrackerX.finder.Finder;
import kaptainwutax.seedcrackerX.render.Cuboid;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ARGB;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.ArrayList;
import java.util.List;

public class LapisOreFinder extends BlockFinder {

    protected static List<BlockPos> SEARCH_POSITIONS;

    public LapisOreFinder(Level world, ChunkPos chunkPos) {
        super(world, chunkPos, Blocks.LAPIS_ORE);
        this.searchPositions = SEARCH_POSITIONS;
    }

    public static void reloadSearchPositions() {
        SEARCH_POSITIONS = Finder.buildSearchPositions(Finder.CHUNK_POSITIONS, pos -> {
            if (pos.getY() < -64) return true;
            return pos.getY() > 64;
        });
    }

    public static List<Finder> create(Level world, ChunkPos chunkPos) {
        List<Finder> finders = new ArrayList<>();
        finders.add(new LapisOreFinder(world, chunkPos));
        return finders;
    }

    @Override
    public List<BlockPos> findInChunk() {
        List<BlockPos> result = super.findInChunk();
        if (result.isEmpty()) return result;

        BlockPos pos = result.get(0);
        this.cuboids.add(new Cuboid(pos, ARGB.color(0, 0, 255)));

        return result;
    }

    @Override
    public boolean isValidDimension(DimensionType dimension) {
        return this.isOverworld(dimension);
    }
}
