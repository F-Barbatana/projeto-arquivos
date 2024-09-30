import axios from 'axios';

const API_URL = 'http://localhost:8080/api'; 

export const getDirectories = async () => {
  const response = await axios.get(`${API_URL}/directories`);
  return response.data;
};

export const getFilesByDirectory = async (directoryId) => {
  const response = await axios.get(`${API_URL}/directories/${directoryId}/files`);
  return response.data;
};

export const getFiles = async () => {
  const response = await axios.get(`${API_URL}/files`);
  return response.data;
};