# Example Mod

![Java](https://img.shields.io/badge/Java-8-red)
![Minecraft](https://img.shields.io/badge/Minecraft-1.16.5-green)
![Forge](https://img.shields.io/badge/Forge-1.16.5-orange)
![License](https://img.shields.io/badge/License-MIT-blue)

[**🇯🇵 日本語の説明はこちら (Go to Japanese Description)**](#example-mod---%E6%97%A5%E6%9C%AC%E8%AA%9E)

---

**Example Mod** is a project aimed at learning and experimenting with Mod development techniques in the Minecraft 1.16.5 (Forge) environment.
It comprehensively implements and verifies elements necessary for modding, ranging from adding custom blocks and models to controlling TileEntity (BlockEntity) behaviors.

## Overview

This mod serves as a sandbox for testing the implementation of the following technical elements:

* **Custom Blocks**: Blocks with special shapes and properties.
* **Model Generation (DataGen)**: Automatic generation of JSON files using BlockStateProvider.
* **TileEntity**: Advanced block behaviors involving data storage and Tick processing.
* **GitHub Actions**: Building a CI/CD environment for automated builds.

## Changelog

### v1.0.1
* **DataGen Implementation**: Added a program for automatic block definition (JSON) generation to improve development efficiency.
* Fixed an issue where Double Slab models were not rendering correctly.

## Requirements

* Minecraft 1.16.5
* Minecraft Forge (1.16.5)
* Java 8

## Usage Policy & Modpacks

⚠️ **Important**

This mod is an **experimental mod intended for development practice and testing purposes**.
Safety against world data corruption or conflicts is not guaranteed. Therefore, please observe the following rules:

* **Inclusion in Modpacks / Distribution**: **Not Allowed**
    * Since this is a test environment, inclusion in public modpacks is prohibited to prevent potential issues.
* **Use in Production Environments**: Not recommended. Please use in a test world with backups.

## License

This project is released under the **MIT License**.
You are free to view, modify, and use the source code for learning purposes.

See [LICENSE](LICENSE) file for details.

## Author

* **AliceIndex**

---

<a id="example-mod---日本語"></a>

# Example Mod - 日本語

**Example Mod** は、Minecraft 1.16.5 (Forge) 環境におけるMod開発の技術習得・実験を目的としたプロジェクトです。
ブロックの追加からカスタムモデル、TileEntity（BlockEntity）の挙動制御まで、Moddingに必要な要素を網羅的に実装・検証しています。

## 概要 (Overview)

このModは、以下の技術的要素の実装テストを行うためのサンドボックスです。

* **カスタムブロックの追加**: 特殊な形状やプロパティを持つブロック。
* **モデル生成 (DataGen)**: BlockStateProvider等を用いたJSONファイルの自動生成。
* **TileEntity**: データの保存やTick処理を行う高度なブロックの挙動。
* **GitHub Actions**: CI/CDによる自動ビルド環境の構築。

## 更新情報 (Changelog)

### v1.0.1
* **DataGenの実装**: ブロック定義(json)の自動生成プログラムを追加し、開発効率を向上。
* ハーフブロック（Slab）の2段重ね（Double Slab）モデルが正しく描画されない問題を修正。

## 動作要件 (Requirements)

* Minecraft 1.16.5
* Minecraft Forge (1.16.5 対応版)
* Java 8

## 利用規約・Modパックについて (Usage Policy)

⚠️ **重要 / Important**

本Modは**開発練習および試験動作を目的とした実験的なMod**です。
ワールドデータの破損や競合に対する安全性が担保されていないため、以下の行為を禁止します。

* **Modパックへの同梱・配布**: **不可 (Not Allowed)**
    * ※あくまで試験環境であり、予期せぬ不具合を防ぐため、公のModパックへの導入は禁止とさせていただきます。
* **本番環境での使用**: 推奨しません。必ずバックアップを取ったテストワールドで使用してください。

## ライセンス (License)

このプロジェクトは **MIT License** の下で公開されています。
ソースコードの閲覧、改造、学習目的での利用は自由に行っていただけます。

詳細は [LICENSE](LICENSE) ファイルをご確認ください。

## 作者 (Author)

* **AliceIndex**
