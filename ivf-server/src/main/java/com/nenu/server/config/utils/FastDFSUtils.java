package com.nenu.server.config.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Breon
 * @description: FastDFS工具类
 * @date: 2022/12/5 20:33
 */
public class FastDFSUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastDFSUtils.class);

    /**
     * 初始化客户端
     * ClientGlobal.init 读取配置文件并初始化对应属性
     */
    static {
        try {
            String path = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(path);
        } catch (Exception e) {
            LOGGER.error("初始化fastDFS失败:", e.getMessage());
        }
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public static String[] upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        LOGGER.info("文件名:", filename);
        StorageClient storageClient = null;

        String[] uploadResults = null;
        try {
            //获取storage客户端
            storageClient = getStorageClient();
            //上传
            uploadResults = storageClient.upload_file(file.getBytes(), filename.substring(filename.lastIndexOf(".") + 1), null);
        } catch (Exception e) {
            LOGGER.error("上传失败:", e.getMessage());
        }
        if (null == uploadResults) {
            LOGGER.error("上传失败", storageClient.getErrorCode());
        }
        return uploadResults;
    }

    /**
     * 获取文件信息
     *
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static FileInfo getFileInfo(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getStorageClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (Exception e) {
            LOGGER.error("文件信息获取失败:", e.getMessage());
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getStorageClient();
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream inputStream = new ByteArrayInputStream(fileByte);
            return inputStream;
        } catch (Exception e) {
            LOGGER.error("下载失败:", e.getMessage());
        }
        return null;
    }

    /**
     * 删除文件
     *
     * @param groupName
     * @param remoteFileName
     */
    public static void deleteFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getStorageClient();
            storageClient.delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            LOGGER.error("删除失败:", e.getMessage());
        }
    }


    /**
     * 生成storage客户端
     *
     * @return
     * @throws IOException
     */
    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }

    /**
     * 生成tracker服务器
     *
     * @return
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getTrackerServer();
        return connection;
    }

    /**
     * 获取文件路径
     *
     * @return
     */
    public static String getTrackerUrl() {
        TrackerClient trackerClient = new TrackerClient();
        StorageServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
            storageServer = trackerClient.getStoreStorage(trackerServer);
            return "http://" + storageServer.getInetSocketAddress().getHostString() + ":8888/";
        } catch (IOException e) {
            LOGGER.error("获取Path失败");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
