# ForgeModdingSkeleton
Skeletons for building Forge mods

## Missing Features:
1) Support Curse ChangeLog from String (Partially done)
2) Sonarqube & Jar Signing Support for Travis
3) Sonarqube & Jar Signing Support for CircleCI
4) Secret parser should support Gradle properties too
5) Fix JUnit3, JUnit4 & JUnit Vintage compatibility (Should be done)
6) Support for JUnit on gradle < 4.6 (Effectively done, Will be on different branch)
7) Jar-in-Jar
8) ContainedDeps
9) Shade
10) Shadow

## Known Caveats:
1) Many versions hard-coded
2) Only supports the maven-publish plugin, not the old maven plugin which also supports SSH Pubkey authentication

## Script related TODO
1) Document secret.json (Partially done)
2) Finish off JUnit5 feature set (I think this is done now)
3) Make sure JaCoCo is integrated correctly with JUnit

## Example Mod TODO:
1) Recipes
2) Fluid
3) Fluid Block
4) Creative Tabs
5) Block with Multiple Textures
