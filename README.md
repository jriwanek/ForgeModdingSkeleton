# ForgeModdingSkeleton
Skeletons for building Forge mods

## TODO
1) Support Curse ChangeLog from String (Partially done)
2) Sonarqube & Jar Signing Support for Travis
3) Sonarqube & Jar Signing Support for CircleCI
4) Secret parser should support Gradle properties too
5) Fix JUnit3, JUnit4 & JUnit Vintage compatibility (Should be done)
6) Support for JUnit on gradle < 4.6 (Effectively done, Needs uncommented and tested)
7) Jar-in-Jar (Partially done)
8) ContainedDeps (Partially done)
9) Shade
10) Shadow
11) Make all gradle version specific bits gated (Mostly complete)
12) Auto-selection selection of FG version based on MC version
13) Auto-selection of Forge latest LB and RB versions
14) Auto-selection of Mappings

## Known Caveats
1) Many versions hard-coded
2) Only supports the maven-publish plugin, not the old maven plugin which also supports SSH Pubkey authentication

## Script related TODO
1) Document secret.json (Partially done)
2) Finish off JUnit5 feature set (I think this is done now)
3) Make sure JaCoCo is integrated correctly with JUnit

## Example Mod TODO
1) Recipes
2) Creative Tabs
3) Block with Multiple Textures
4) Entities
5) Networking
6) Capabilities
7) Multiblock structures
8) Worldgen: Ore and Structure generation
