# sbtnatimage

This is a simple scala project mainly to exercise <https://github.com/scalameta/sbt-native-image>
along with Github Actions to create binary releases for Linux, MacOS, and Windows.

The general setup here is rather adhoc, but it may still be useful to someone out there.

---

On your host machine:

      $ sbt

      sbt:sbtnatimage> sbtnatimage/nativeImage

      sbt:sbtnatimage> sbtnatimage/nativeImageRun hey there
      hey there


Release workflow: [.github/workflows/native.yml](.github/workflows/native.yml)

Some notes:

- Release 0.0.2 with the use of [UPX](https://upx.github.io/)
  (via [svenstaro/upx-action](https://github.com/svenstaro/upx-action)).

- The linux executable will be statically linked.
  Just remove the `--static` option for a dynamically linked one.
  (Or, create both artifacts depending on your needs, etc.)
  
- The MacOS executable won't be signed; so, upon downloading it, the user 
  will need to do something like the following to be able to run it:
  
        xattr -d com.apple.quarantine sbtnatimage

- Windows executable untested.

